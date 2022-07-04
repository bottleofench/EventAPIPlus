# EventAPI+

An API that adding a bunch of extra events to make it easier to develop plugins on SpigotAPI / PaperAPI.

## Adding to the project
Add Jitpack repository to pom.xml:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

```
Add dependency to pom.xml:
```xml
<dependency>
    <groupId>com.github.LifelineMC</groupId>
    <artifactId>EventAPIPlus</artifactId>
    <version>master-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```


## List of events
- FrostWalkerUseEvent
- ItemFrameCreateEvent
- FarmlandTrampleEvent