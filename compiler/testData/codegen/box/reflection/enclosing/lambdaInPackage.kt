// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

val l: Any = {}

fun box(): String {
    val enclosingClass = l.javaClass.getEnclosingClass()!!.getName()
    if (enclosingClass != "LambdaInPackageKt") return "enclosing class: $enclosingClass"

    val enclosingConstructor = l.javaClass.getEnclosingConstructor()
    if (enclosingConstructor != null) return "enclosing constructor found: $enclosingConstructor"

    val enclosingMethod = l.javaClass.getEnclosingMethod()
    if (enclosingMethod != null) return "enclosing method found: $enclosingMethod"

    val declaringClass = l.javaClass.getDeclaringClass()
    if (declaringClass != null) return "anonymous function has a declaring class: $declaringClass"

    return "OK"
}
