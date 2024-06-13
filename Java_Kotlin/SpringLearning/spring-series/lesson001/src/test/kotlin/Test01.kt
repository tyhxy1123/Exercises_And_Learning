import com.javacode2018.lesson001.demo1.*
import com.javacode2018.lesson001.demo1.application.context.aware.ServiceA
import com.javacode2018.lesson001.demo1.application.context.aware.ServiceB
import com.javacode2018.lesson001.demo1.application.context.aware.ServiceC
import com.javacode2018.lesson001.demo1.application.context.aware.method.replacer.ServiceCMethodReplacer
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

class Test01 {
    val xmlPath = "bean.xml"
    val context1 = context(xmlPath)

    @Test
    fun diByConstructorParamIndex() {
        println(context1.getBean("DIByConstructorParamIndex"))
    }

    @Test
    fun diByConstructorParamName() {
        println(context1.getBean("benz1"))
    }

    @Test
    fun diBySetter() {
        println(context1.getBean("menu1"))
    }

    val context2 = context("diBean.xml")

    @Test
    fun diBean() {
        println(context2.getBean("diBeanByConstructor"))
        println(context2.getBean("diBeanBySetter"))
    }

    @Test
    fun diOtherType() {
        println(context2.getBean("diOtherTypeConstructor"))
        println(context2.getBean("diOtherTypeSetter"))
    }

    @Test
    fun assignable() {
        println(Object::class.java.isAssignableFrom(Integer::class.java))
        println(Object::class.java.isAssignableFrom(Int::class.java))
        println(Object::class.java.isAssignableFrom(List::class.java))
        println(Collection::class.java.isAssignableFrom(List::class.java))
        println(List::class.java.isAssignableFrom(Collection::class.java))
    }

    @Test
    fun diAutowireName() {
        val xmlPath = "diAutowireByName.xml"
        val context = ClassPathXmlApplicationContext(xmlPath)
        println(context.getBean("diAutowireByName1"))
        println(context.getBean("diAutowireByName2"))
    }

    @Test
    fun diAutowireType() {
        val context = context("diAutowireByType.xml")
        println(context.getBean("diAutowireByType"))
    }

    @Test
    fun diAutowireTypeExtend() {
        val context = context("diAutowireByTypeExtend.xml")
        println(context.getBean("diByAutowireTypeExtend", DiByAutowireTypeExtend::class.java))
    }

    @Test
    fun diAutowireByConstructor() {
        val context = context("diAutowireByConstructor.xml")
        println(context.getBean("diAutowireByConstructor", DiAutowireByConstructor::class.java))
    }

    @Test
    fun normalBean() {
        println("Container initializing...")
        val context = context("normalBean.xml")
        println("Finished, prepare to close the container")
        context.close()
        println("Container closed")
    }

    @Test
    fun strongDependencyBean() {
        println("Container initializing...")
        val context = context("strongDependencyBean.xml")
        println("Finished, prepare to close the container")
        context.close()
        println("Container closed")
    }

    @Test
    fun dependOnBean() {
        println("Container initializing...")
        val context = context("dependOnBean.xml")
        println("Finished, prepare to close the container")
        context.close()
        println("Container closed")
    }

    @Test
    fun primaryBean() {
        val context = context("primaryBean.xml")
        println(context.getBean(PrimaryBean::class.java))
    }

    @Test
    fun primaryBean2() {
        val context = context("primaryBean.xml")
        println(context.getBean(PrimaryBean::class.java))
    }

    @Test
    fun lazyInitBean() {
        val context = context("lazyInitBean.xml")
        println("Container init fertig!")
        println("Begin searching the bean in the Container")
        val lazyBean = context.getBean(LazyInitBean::class.java)
        val diligentBean = context.getBean(LazyInitBean.DiligentBean::class.java)
        println("LazyInitBean: $lazyBean")
        println("DiligentBean: $diligentBean")
    }

    @Test
    fun extendBean() {
        val context = context("extendBean.xml")
        println(context.getBean("s1"))
        println(context.getBean("s2"))
    }

    @Test
    fun applicationContextAware() {
        val context = context("ApplicationContextAware/applicationContextAware.xml")
        println(context.getBean(ServiceA::class.java))
        println(context.getBean(ServiceB::class.java))
        println(context.getBean(ServiceB::class.java))
        println(context.getBean(ServiceB::class.java))
        println(context.getBean(ServiceB::class.java))
        println(context.getBean(ServiceB::class.java))
    }

    @Test
    fun lookupMethod() {
        val context = context("ApplicationContextAware/applicationContextAware.xml")
        println(context.getBean(ServiceA::class.java))
        val sC = context.getBean(ServiceC::class.java)
        sC.say()
        sC.say()
    }

    @Test
    fun methodReplacer() {
        val context = context("ApplicationContextAware/methodReplacer.xml")
        println(context.getBean(ServiceA::class.java))
        val p2 = context.getBean(ServiceC::class.java)
        p2.say()
        p2.say()
    }
}