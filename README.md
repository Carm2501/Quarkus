# my-aktion project
In diesem Projekt wird die bestehende Anwendung my-aktion von Wildfly auf den Server Quarkus (https://code.quarkus.io/) migriert. JSF wird auf Quarkus durch eine Extension ermöglicht. Außerdem unterstützt Quarkus mit Quarkus DI (https://quarkus.io/guides/cdi-reference) die verwendete CDI Annotation nur teilweise. Aus diesem Grund wurde die Migration mit dem Code-Stand "CDI" gestartet. Der Code wurde dann an Quarkus angepasst. Anschließend wurden die JPA Annotationen hinzugefügt und die Datenbank H2 hinzugefügt.

## JSF auf Quarkus
Eine bestimmte org.apache.myfaces Extension wird benötigt (https://mvnrepository.com/artifact/org.apache.myfaces.core.extensions/myfaces-quarkus).
Wenn Beans keinen expliziten Scope haben, wird automatisch @Dependent vergeben. @Dependent wird von JSF-Extension (aktuell) nicht berücksichtigt. Aus diesem Grund müssen v.a. @Produces mit einem Scope annotiert werden.

### Quarkus DI Annotationen
Kein @Stateless möglich, dafür muss @Transactional + Scope verwendet werden. Die Klassen 

#### JPA
die JSF-Extension unterstützt keine @Embeddable Annotation (https://stackoverflow.com/questions/61211391/are-composite-primary-keys-in-jpa-with-quarkus-possible, https://github.com/quarkusio/quarkus/issues/2198). Deswegen wurden die Attribute aus der Klase Account den Klassen Campaign und Donation jeweils separat hinzugefügt.

##### Einbindung H2

Die embedded Datenbank wurde über application.properties eingebunden.

###### Deployment
Um die Anwendung im Development Modus zu starten, muss das Repository mittels des Befehls "mvn package quarkus:dev" gestartet werden. Das besondere im Dev-Mode: Änderungen am Code werden in Echtzeit übernommen (Live Coding). Der produktive Modus wird nach "mvn package" mit dem Befehl "java -jar target/my-aktion-1.0.0-SNAPSHOT-runner.jar" gestartet. Die Applikation ist erreichbar unter folgender URL: http://localhost:8080/

###### Weitere Punkte

-Die mit @Namend annotierten Methoden wurden durch die EL im JSF nicht korrekt containerisiert. Deswegen wurde die @Named Annotation auf Klassen-Ebene eingefügt und dem enstprechend über die Klasse auf die Methoden bzw. Attribute zugegriffen.
-Alle @Inject Attribute wurden mit package-private deklariert, da Quarkus dadurch eine bessere Performance erreicht.
-view.local.language wurde statisch auf de gestellt, da 'view.locale.language durch die JSF Extension zu einer javax.enterprise.inject.IllegalProductException führt