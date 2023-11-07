# Utilisez une image OpenJDK 8
FROM openjdk:8-jre

# Copiez le contenu du répertoire "target" de votre projet à la racine du conteneur
ADD target/achat-1.0.jar achat-1.0.jar

# Exposez le port sur lequel votre application Java écoutera (utilisez un port disponible qui ne soit pas en conflit avec d'autres services)
EXPOSE 8089

# Définissez la commande d'entrée pour exécuter votre application Java (utilisez le nom du JAR correct)
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar "]