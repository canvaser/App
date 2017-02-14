#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_siweisoft_nurse_ui_user_login_activity_LoginActivity_test(JNIEnv* env,jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}