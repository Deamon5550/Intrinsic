Gives access to the RDTSC instruction from java. RDTSC returns the value of the processor timestamp
counter. Compared to `System.nanoTime()` I have found it to be slightly slower (9.5ns compared to
anywhere from 5 to 13ns for System#nanoTime), but what you gain is greatly increased accuracy.

On older processors the timestamp counter was an unreliable means of time measurement at best. It precisely
followed the cpu clock ticks which means it was subject to variance as the frequency of the CPU was
scaled to conserve power. Modern processors however (with the INVARIANT_TSC flag set) have decoupled
the timestamp counter from the actual clock ticks making it usable as a time source again.

The returned value is in clock ticks but if you look in the test file there is a means of measuring
a value of nanoseconds per clock tick which can be used to convert durations into human readable
time measurements.

Earlier I mentioned the inaccuracy of System#nanoTime. Testing on my system the values returned from
System#nanoTime only increase every 277 nanoseconds. This greatly hampers the accuracy of short
duration time measurements. Comparatively RDTSC can measure durations 5x shorter than this and with
smaller variance in the measurements.

Disclaimer: When benchmarking functions longer durations are always preferred over shorter durations.
I am not advocating using RDTSC to time single runs of functions for the purposes of comparison or
analysis.