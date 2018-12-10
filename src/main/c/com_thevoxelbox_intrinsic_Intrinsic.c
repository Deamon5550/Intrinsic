
#include <jni.h>
#include <inttypes.h>

JNIEXPORT jlong JNICALL Java_com_thevoxelbox_intrinsic_Intrinsic_rdtsc
  (JNIEnv *env, jclass cls)
{
  unsigned hi, lo;
  __asm__ __volatile__ ("rdtsc" : "=a"(lo), "=d"(hi));
  return ((uint64_t) lo) | (((uint64_t) hi) << 32);
}