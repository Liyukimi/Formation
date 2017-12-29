$(function () {

    function initMap() {

		var location = new google.maps.LatLng(48.8574449, 2.36835659999997);
		
        var mapCanvas = document.getElementById('map');
        var mapOptions = {
            center: location,
            zoom: 12,
            panControl: false,
            scrollwheel: false,
            mapTypeId: google.maps.MapTypeId.ROADMAP
		}
        var map = new google.maps.Map(mapCanvas, mapOptions);
		
        var styles = [{"featureType":"administrative","elementType":"labels.text","stylers":[{"weight":"1.92"}]},{"featureType":"administrative","elementType":"labels.text.fill","stylers":[{"color":"#000000"}]},{"featureType":"landscape","elementType":"all","stylers":[{"color":"#f2f2f2"}]},{"featureType":"landscape","elementType":"labels.text","stylers":[{"weight":"0.77"},{"lightness":"-28"},{"saturation":"100"},{"visibility":"on"},{"color":"#ea8538"}]},{"featureType":"poi","elementType":"all","stylers":[{"visibility":"off"}]},{"featureType":"poi.business","elementType":"all","stylers":[{"visibility":"on"}]},{"featureType":"road","elementType":"all","stylers":[{"saturation":"59"},{"lightness":"-30"},{"visibility":"simplified"},{"weight":"0.41"},{"hue":"#ff6e00"},{"gamma":"1.52"}]},{"featureType":"road.highway","elementType":"all","stylers":[{"visibility":"simplified"}]},{"featureType":"road.arterial","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"all","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"all","stylers":[{"color":"#516483"},{"visibility":"on"},{"lightness":"76"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"color":"#6f6259"},{"lightness":"0"}]}];
        map.set('styles', styles);
		
		/********************************************
		**	LES MARQUEURS
		*********************************************/
		// Salon 
		var salonMarker = new google.maps.Marker({
			position: location,
			map: map,
			title: 'La Moustacherie'
		});
        var salonString = '<div class="info-window">' +
			'<h4>La Moustacherie</h4>' +
			'<div class="info-content">' +
			'<p>Notre premier salon ! </p>' +
			'</div>' +
			'</div>';
				
        var infowindow = new google.maps.InfoWindow({
            content: salonString,
            maxWidth: 400
        });
        salonMarker.addListener('click', function () {
            infowindow.open(map, salonMarker);
        });
		
		// Boutique
		var boutiqueMarker = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8494449, 2.308612300000034),
                    map: map,
                    title: 'Salon Big Moustache!'
                });
        var boutiqueString = '<div class="info-window">' +
                '<h4>Salon Big Moustache!</h4>' +
                '<div class="info-content">' +
                '<p>Un de nos partenaires</p>' +
                '</div>' +
                '</div>';
				
        var infowindow1 = new google.maps.InfoWindow({
            content: boutiqueString,
            maxWidth: 400
        });
        boutiqueMarker.addListener('click', function () {
            infowindow1.open(map, boutiqueMarker);
        });	
	
		// Boutique2
		var boutiqueMarker2 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8494449, 2.37835659999997),
                    map: map,
                    title: 'Salon de coiffure2'
                });
        var boutique2String = '<div class="info-window">' +
                '<h4>Salon de coiffure2</h4>' +
                '<div class="info-content">' +
                '<p>Un de nos partenaires</p>' +
                '</div>' +
                '</div>';
				
        var infowindow2 = new google.maps.InfoWindow({
            content: boutique2String,
            maxWidth: 400
        });
        boutiqueMarker2.addListener('click', function () {
            infowindow2.open(map, boutiqueMarker2);
        });
			
		// Boutique3
		var boutiqueMarker3 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8574449, 2.319612300000034),
                    map: map,
                    title: 'Salon de coiffure3'
                });
        var boutique3String = '<div class="info-window">' +
                '<h4>Salon de coiffure3</h4>' +
                '<div class="info-content">' +
                '<p>Un de nos partenaires</p>' +
                '</div>' +
                '</div>';
				
        var infowindow3 = new google.maps.InfoWindow({
            content: boutique3String,
            maxWidth: 400
        });
        boutiqueMarker3.addListener('click', function () {
            infowindow3.open(map, boutiqueMarker3);
        });
		
		// Boutique4
		var boutiqueMarker4 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8707478, 2.34268690888034),
                    map: map,
                    title: 'Salon de coiffure4'
                });
        var boutique4String = '<div class="info-window">' +
                '<h4>Salon de coiffure4</h4>' +
                '<div class="info-content">' +
                '<p>Un de nos partenaires</p>' +
                '</div>' +
                '</div>';
				
        var infowindow4 = new google.maps.InfoWindow({
            content: boutique4String,
            maxWidth: 400
        });
        boutiqueMarker4.addListener('click', function () {
            infowindow4.open(map, boutiqueMarker4);
        });
		
		//Autres marqueurs
		var boutiqueMarker5 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8534449, 2.298612300000034),
                    map: map,
                    title: 'Barbier'
                });
		var boutiqueMarker6 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8534449, 2.38835659999997),
                    map: map,
                    title: 'Barbier 2'
                });
				
		var boutiqueMarker7 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8579449, 2.291612300000034),
                    map: map,
                    title: 'Barbier 3'
                });
		var boutiqueMarker8 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8579449, 2.39435659999997),
                    map: map,
                    title: 'Barbier 4'
                });
		var boutiqueMarker9 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8628449, 2.329612300000034),
                    map: map,
                    title: 'Barbier 5'
                });
		var boutiqueMarker10 = new google.maps.Marker({
                    position: new google.maps.LatLng(48.8628449, 2.35835659999997),
                    map: map,
                    title: 'Barbier 6'
                });
				
    }

    google.maps.event.addDomListener(window, 'load', initMap);
});