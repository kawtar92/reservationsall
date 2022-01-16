$(document)
		.ready(
				function() {

					table = $('#treservation')
							.DataTable({
										ajax : {
											url : "reservations/all",
											dataSrc : ''
										},
										columns : [
												{
													data : "id"
												},
												{
													data : "date"
												},
												{
													data : "creneau.hDebut"
												},
												{
													data : "creneau.hFin"
												},
												{
													data : "salle.code"
												},
												{
													data : "user.username"
												},
												
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
													}
												},
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
													}
												} ]

									});
					
					$.ajax({
						url:'/creneaux/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.id+'>'+e.hDebut+" / "+e.hFin +'</option>';
							});
							
						$('#creneau').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});
					$.ajax({
						url:'/salles/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.id+'>'+e.code+'</option>';
							});
							
						$('#salle').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});
					$.ajax({
						url:'/users/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.id+'>'+e.username+'</option>';
							});
							
						$('#user').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});

					$('#btn').click(
							function() {
								var date = $("#date");
								var creneau = $("#creneau");
								var salle = $("#salle");
							var user = $("#user");

								if ($('#btn').text() == 'Ajouter') {
									var p = {
										date : date.val(),
										creneau : {
											id : creneau.val()
										},
										salle : {
											id : salle.val()
										},
									     user : {
											id : user.val()
										}
									};

									$.ajax({
										url : 'reservations/save',
										contentType : "application/json",
										dataType : "json",
										data : JSON.stringify(p),
										type : 'POST',
										async : false,
										success : function(data, textStatus,
												jqXHR) {
											table.ajax.reload();
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.log(textStatus);
										}
									});
									$("#main-content").load(
											"./page/reservation.html");
								}
							});

					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {

										var id = $(this).closest('tr').find(
												'td').eq(0).text();
										var oldLing = $(this).closest('tr')
												.clone();
										var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">'
												+ id
												+ '</th><td colspan="4" style="height: 100%;">';
										newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer ce creneau ? </h4>';
										newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette salle ? </h4>';
										newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
										newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

										$(this).closest('tr').replaceWith(
												newLigne);
										$('.annuler').click(
												function() {
													$(this).closest('tr')
															.replaceWith(
																	oldLing);
												});
										$('.confirmer')
												.click(
														function(e) {
															e.preventDefault();
															$
																	.ajax({
																		url : 'reservations/delete/'
																				+ id,
																		data : {},
																		type : 'DELETE',
																		async : false,
																		success : function(
																				data,
																				textStatus,
																				jqXHR) {
																			if (data
																					.includes("error") == true) {
																				$(
																						"#error")
																						.modal();
																			} else {
																				table.ajax
																						.reload();
																			}
																		},
																		error : function(
																				jqXHR,
																				textStatus,
																				errorThrown) {
																			$(
																					"#error")
																					.modal();
																		}
																	});

														});

									});

					$('#table-content').on(
							'click',
							'.modifier',
							function() {
								var btn = $('#btn');
								var id = $(this).closest('tr').find('td').eq(0)
										.text();
								
								var date = $(this).closest('tr').find('td').eq(
										1).text();
								var creneau = $(this).closest('tr').find('td')
								.eq(2).text();
								var salle = $(this).closest('tr').find('td')
								.eq(3).text();
								var user = $(this).closest('tr').find('td')
								.eq(4).text();
							
								
								btn.text('Modifier');
								$("#date").val(date);
								var op = $('#creneau option').filter(function () { return $(this).html() == creneau; }).val();
								$("#creneau").val(op);
								var op = $('#salle option').filter(function () { return $(this).html() == salle; }).val();
								$("#salle").val(op);
								$("#id").val(id);
								var op = $('#user option').filter(function () { return $(this).html() == user; }).val();
								$("#user").val(op);
								$("#id").val(id);
								
								btn.click(function(e) {
									e.preventDefault();
									var p = {
										id : $("#id").val(),
										date : $("#date").val(),
										creneau : {
											id : $("#creneau").val()
											
										},
										salle : {
											id : $("#salle").val()
											
										},
									      user : {
											id : $("#user").val()
											
										}
										
									};
									if ($('#btn').text() == 'Modifier') {
										$.ajax({
											url : 'reservations/save',
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'POST',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												table.ajax.reload();
												$("#date").val('');
												$("#creneau").val('');
												$("#salle").val('');
												$("#user").val('');

												btn.text('Ajouter');
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#main-content").load(
												"./page/reservation.html");
									}
								});
							});

					
				});
