#include <jni.h>
#include <string>

JNIEXPORT jstring JNICALL
Java_com_siweisoft_test_main_Test_sayHello(JNIEnv *env, jclass type) {

    // TODO


    return env->NewStringUTF("123");
}

extern "C"
jstring
Java_com_siweisoft_nurse_ui_user_login_activity_LoginActivity_test(JNIEnv *env,
                                                                   jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}