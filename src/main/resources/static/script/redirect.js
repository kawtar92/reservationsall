$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("page/statistiques.html");

function show(page) {
	if (page == 'produit') {
		$('a').removeClass('active');
		$('a:contains(Produit)').addClass('active');
		$("#main-content").load("page/produit.html");

		event.preventDefault();
	}
	if (page == "statistiques") {
		$('a').removeClass('active');
		$('a:contains(Statistiques)').addClass('active');
		$("#main-content").load("page/statistiques.html");
		event.preventDefault();
	}
	if (page == "marques") {
		$('a').removeClass('active');
		$('a:contains(Marques)').addClass('active');
		$("#main-content").load("page/marque.html");
		event.preventDefault();
	}
	if (page == "machines") {
		$('a').removeClass('active');
		$('a:contains(Machines)').addClass('active');
		$("#main-content").load("page/machine.html");
		event.preventDefault();
	}if (page == "salles") {
		$('a').removeClass('active');
		$('a:contains(Salles)').addClass('active');
		$("#main-content").load("page/salle.html");
		event.preventDefault();
	}if (page == "blocs") {
		$('a').removeClass('active');
		$('a:contains(Blocs)').addClass('active');
		$("#main-content").load("page/bloc.html");
		event.preventDefault();
   }if (page == "creneaux") {

		$('a').removeClass('active');
		$('a:contains(creneaux)').addClass('active');
		$("#main-content").load("page/creneau.html");
		event.preventDefault();
		
   }if (page == "reservations") {
		$('a').removeClass('active');
		$('a:contains(Reservations)').addClass('active');
		$("#main-content").load("page/reservation.html");
		event.preventDefault();
   
   }
}