# Utilisez une image OpenJDK 8
FROM openjdk:8-jre

# Copiez le contenu du r�pertoire "target" de votre projet � la racine du conteneur
ADD target/achat-1.0.jar achat-1.0.jar

# Exposez le port sur lequel votre application Java �coutera (utilisez un port disponible qui ne soit pas en conflit avec d'autres services)
EXPOSE 8089

# D�finissez la commande d'entr�e pour ex�cuter votre application Java (utilisez le nom du JAR correct)
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar "]