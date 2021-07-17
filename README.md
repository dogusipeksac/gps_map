# gps_map
for street
@Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(36.981351, 35.319413));
        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setPanningGesturesEnabled(true);
    }
