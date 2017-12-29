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
		
        var styles = [{"featureType":"all","elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#ffffff"},{"lightness":40}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#000000"},{"lightness":43}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":17},{"weight":1.2}]},{"featureType":"administrative.locality","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"administrative.neighborhood","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.fill","stylers":[{"lightness":"17"}]},{"featureType":"administrative.land_parcel","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"landscape","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"landscape.man_made","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape.man_made","elementType":"labels.text","stylers":[{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":28}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"visibility":"on"},{"color":"#ff4700"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"lightness":17}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#ffffff"},{"lightness":43},{"weight":0.2}]},{"featureType":"road.highway","elementType":"labels","stylers":[{"invert_lightness":true},{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#3b3b3b"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":18}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"color":"#ff4700"},{"lightness":"39"},{"gamma":"0.43"},{"saturation":"-47"}]},{"featureType":"road.arterial","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":16}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"color":"#555555"}]},{"featureType":"road.local","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":19}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":17}]}];
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