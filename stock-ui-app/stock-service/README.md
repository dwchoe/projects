# stock-service

##TODO:
1. stocks/read must not be accessible


##hosted URLs
* http://stock-services.herokuapp.com/stocks
* https://stock-services.herokuapp.com/stocks


##deploy to Heroku
<a href="https://devcenter.heroku.com/categories/heroku-architecture">heroku architecture</a> <br>
<a href="https://devcenter.heroku.com/articles/dynos">dynos</a> - virtual machine on Heroku <br>
<a href="https://devcenter.heroku.com/articles/slug-compiler">slug</a> - prepackage deployment artifact running in dynos<br>

(1) build.gradle - add the following in the dependency<br>
```
provided "org.springframework.boot:spring-boot-starter-tomcat"
```

(2) build.gradle - add stage task
```
task stage() {
    dependsOn clean, war
}
tasks.stage.doLast() {
    delete fileTree(dir: "build/distributions")
    delete fileTree(dir: "build/assetCompile")
    delete fileTree(dir: "build/distributions")
    delete fileTree(dir: "build/libs", exclude: "*.war")
}
war.mustRunAfter clean
```

(3) mkdir server at root level in the workspace<br>
```
curl -O http://repo2.maven.org/maven2/com/github/jsimone/webapp-runner/7.0.34.3/webapp-runner-7.0.34.3.jar
```

(4) create Procfile file - add the following<br>
```
web: cd build/libs ; java $JAVA_OPTS -Dgrails.env=prod -jar ../../server/webapp-runner.jar --port $PORT *.war
```

(5) create system.properties - adding the following<br>
```
java.runtime.version=1.8
```
