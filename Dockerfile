# Étape 1 : image de base
FROM openjdk:17-jdk-slim

# Étape 2 : définir le répertoire de travail
WORKDIR /app

# Étape 3 : copier le JAR généré par Maven
COPY target/*.jar app.jar

# Étape 4 : exposer le port de l’application
EXPOSE 8080

# Étape 5 : commande de démarrage
CMD ["java", "-jar", "app.jar"]
