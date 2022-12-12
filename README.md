# Honeycomb SDK and Agent interaction

When cloning this repository and executing the provided `./run.sh`,
you'll oberserve the following error:

```java
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'otelSetup': Invocation of init method failed
 at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:195) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:420) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1743) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:961) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:915) ~[spring-context-6.0.2.jar!/:6.0.2]
 at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[spring-context-6.0.2.jar!/:6.0.2]
 at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:730) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:432) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at org.springframework.boot.SpringApplication.run(SpringApplication.java:308) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[spring-boot-3.0.0.jar!/:3.0.0]
 at me.vringar.opentelementryspringboot.OpentelementrySpringBootApplication.main(OpentelementrySpringBootApplication.java:10) ~[classes!/:0.0.1-SNAPSHOT]
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
 at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
 at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
 at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) ~[opentelementry-spring-boot-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
 at org.springframework.boot.loader.Launcher.launch(Launcher.java:95) ~[opentelementry-spring-boot-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
 at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) ~[opentelementry-spring-boot-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
 at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65) ~[opentelementry-spring-boot-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
Caused by: java.lang.NoClassDefFoundError: io/opentelemetry/sdk/trace/samplers/Sampler
 at java.base/java.lang.ClassLoader.findBootstrapClass(Native Method) ~[na:na]
 at java.base/java.lang.ClassLoader.findBootstrapClassOrNull(ClassLoader.java:1262) ~[na:na]
 at java.base/java.lang.System$2.findBootstrapClassOrNull(System.java:2310) ~[na:na]
 at java.base/jdk.internal.loader.ClassLoaders$BootClassLoader.loadClassOrNull(ClassLoaders.java:140) ~[na:na]
 at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:700) ~[na:na]
 at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:676) ~[na:na]
 at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:700) ~[na:na]
 at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:676) ~[na:na]
 at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639) ~[na:na]
 at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
 at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:574) ~[na:na]
 at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:149) ~[opentelementry-spring-boot-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
 at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520) ~[na:na]
 at io.honeycomb.opentelemetry.OpenTelemetryConfiguration$Builder.<init>(OpenTelemetryConfiguration.java:48) ~[honeycomb-opentelemetry-sdk-1.4.0.jar!/:na]
 at io.honeycomb.opentelemetry.OpenTelemetryConfiguration$Builder.<init>(OpenTelemetryConfiguration.java:46) ~[honeycomb-opentelemetry-sdk-1.4.0.jar!/:na]
 at io.honeycomb.opentelemetry.OpenTelemetryConfiguration.builder(OpenTelemetryConfiguration.java:433) ~[honeycomb-opentelemetry-sdk-1.4.0.jar!/:na]
 at me.vringar.opentelementryspringboot.OtelSetup.honeycomb(OtelSetup.java:21) ~[classes!/:0.0.1-SNAPSHOT]
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
 at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
 at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
 at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement.invoke(InitDestroyAnnotationBeanPostProcessor.java:424) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:368) ~[spring-beans-6.0.2.jar!/:6.0.2]
 at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:192) ~[spring-beans-6.0.2.jar!/:6.0.2]
 ... 26 common frames omitted
```

This error can be fixed when starting without the agent.