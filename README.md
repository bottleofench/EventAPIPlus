# EventAPI+

An API that adding a bunch of extra events to make it easier to develop plugins on SpigotAPI / PaperAPI.

## Adding to the project

### Maven

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.LifelineMC</groupId>
    <artifactId>EventAPIPlus</artifactId>
    <version>-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

### Gradle
```
allprojects {
    repositories {
    	...
    	maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.LifelineMC:EventAPIPlus:-SNAPSHOT'
}
```

## List of events
- FrostWalkerUseEvent
- ItemFrameCreateEvent
- FarmlandTrampleEvent