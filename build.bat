@echo off

gcc -o Intrinsic.dll -shared -I"C:\Program Files\Java\jdk1.8.0_121\include" -I"C:\Program Files\Java\jdk1.8.0_121\include\win32" -Isrc/main/c src/main/c/com_thevoxelbox_intrinsic_Intrinsic.c

pause