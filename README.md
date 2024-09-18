# ideaview

**IdeaView** est une plateforme d'échange spécialisée dans la création de projet digital. Ce projet inclut une application front-end développée avec Angular et une API back-end sécurisée avec Spring Boot.

## Table des Matières
1. [Prérequis](#prérequis)
2. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [API Documentation](#api-documentation)
6. [Technologies](#technologies)
7. [Contribuer](#contribuer)
8. [Licence](#licence)

## Prérequis

Avant de commencer, assurez-vous d’avoir les éléments suivants installés sur votre machine :

- [Node.js](https://nodejs.org/en/) (version 14 ou supérieure)
- [Angular CLI](https://angular.io/cli)
- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Postgresql](https://www.postgresql.org/)

## Installation

### 1. Clonez le dépôt

```bash
git clone https://github.com/JourdanKyllian/ideaview.git
cd ideaview

2. Installation du Front-end

- cd frontend
- npm install
- ng serve
Le front-end sera accessible sur http://localhost:4200.

3. Installation du Back-end

- cd backend
- mvn install
- java -jar target/api-0.0.1-SNAPSHOT.jar
Le back-end sera accessible sur http://localhost:8080.
```

## Utilisation

Lancer le projet localement

Lancer le back-end : Depuis le répertoire backend, exécutez :
- java -jar target/api-0.0.1-SNAPSHOT.jar

Lancer le front-end : Depuis le répertoire frontend, exécutez :
- ng serve 
Accédez à l'application via http://localhost:4200 ou ajoutez ' -o' apres la commande ci-dessus.

Lancer les tests
Tests unitaires Front-end :
- cd frontend
- ng test

Tests Back-end :
- cd backend/ideaview
- mvn test

## API Documentation

L'API REST de IdeaView expose plusieurs endpoints pour gérer les utilisateurs, projet, et commandes. Voici un aperçu des principales routes :

Authentification
POST /api/open/login: Authentifie un utilisateur.
POST /api/open/register: Inscrit un nouvel utilisateur.
POST /api/open/logout: deconnecte l'utilisateur.

Projet
POST /api/project/save: Creer un projet.
GET /api/project/delete/{id}: Récupère les détails d’un produit.
POST /api/dashboard/update/{id} : modifie un projet.
DELETE /api/dashboard/delete/{id} : Supprime un projet.


Suggestion
POST /api/suggestion/save: Creer une suggestion.
GET /api/suggestion/list : Liste toutes les suggestions d'un projet.
POST /api/suggestion/delete/{id}: Suprimme la suggestion.


Sécurité des API
L'authentification des routes protégées est gérée via des JWT (JSON Web Tokens). Assurez-vous de bien configurer les tokens dans les requêtes pour accéder aux routes sécurisées.

## Technologies

Le projet IdeaView utilise les technologies suivantes :

Front-end : Angular (TypeScript, HTML, SCSS)
Back-end : Spring Boot (Java)
Base de données : Postgresql
Authentification : JSON Web Tokens (JWT)
Sécurité : Spring Security, SSL/TLS pour HTTPS, BCrypt pour le hachage des mots de passe

## Contribuer

Les contributions sont les bienvenues ! Pour contribuer :

Forkez ce dépôt.
Créez une branche pour votre fonctionnalité (git checkout -b feature/nouvelle-fonctionnalité).
Commitez vos modifications (git commit -m 'Ajout d'une nouvelle fonctionnalité').
Poussez sur la branche (git push origin feature/nouvelle-fonctionnalité).
Soumettez une Pull Request.
