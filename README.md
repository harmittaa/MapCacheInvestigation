# MapCacheInvestigation

Simple side by side comparison of GoogleMaps Android [MapView](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView)
and [SupportMapFragment](https://developers.google.com/android/reference/com/google/android/gms/maps/SupportMapFragment). The main takeaway is the possibility to 
view how different map presentations handle caching when moving between fragments.

In short, SupportMapFragment caches markers and drawings while MapView does not, even though all lifecycle callbacks are directed to it.


### Demo

![Recording of functionality](https://raw.githubusercontent.com/harmittaa/MapCacheInvestigation/master/documents/map_recording.gif)
