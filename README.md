

## Usage



L&#39;API devra permettra de réaliser le scénario suivant :

- Création d’un message de la part de « Jérémie Durand », avec le contenu suivant : « Bonjour,
  j’ai un problème avec mon nouveau téléphone »

```json
curl --location --request POST 'http://localhost:8080/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{
    "auteur" : "Jérémie Durand",
    "contenu" : "« Bonjour, j’ai un problème avec mon nouveau téléphone",
    "canal" : "SMS"
}'
```



- Création d’un dossier client, avec pour nom du client « Jérémie Durand », et avec le message
  précédent dans la liste

```json
curl --location --request POST 'http://localhost:8080/api/dossier' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message_uuid" : "0cd08c53-1b39-444d-91e7-567797157e75"
}'
```

> le message_uuid contient la référence du message précédemment généré.



- Création d’un message de la part de « Sonia Valentin », avec le contenu suivant : « Je suis
  Sonia, et je vais mettre tout en œuvre pour vous aider. Quel est le modèle de votre
  téléphone ? » ; ce message sera rattaché au dossier client précédent

```json
curl --location --request POST 'http://localhost:8080/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{
    "auteur" : "Sonia Valentin",
    "contenu" : "Je suis Sonia, et je vais mettre tout en œuvre pour vous aider. Quel est le modèle de votre téléphone ?",
    "canal" : "SMS",
    "dossier_uuid" : "3464c984-5953-4438-99ec-ab43f0ff4246"
}'
```

> le dossier_uuid contient la référence du dossier précédemment généré.





- Modification du dossier client en ajoutant la référence client : « KA-18B6 ». Cela permet de
  valider l’API qui modifie un dossier client.

```json
curl --location --request PATCH 'http://localhost:8080/api/dossier' \
--header 'Content-Type: application/json' \
--data-raw '{
    "uuid" : "3464c984-5953-4438-99ec-ab43f0ff4246",
    "reference" : "KA-18B6"
}'
```

> le uuid contient la référence du dossier précédemment généré.



- Récupération de tous les dossiers clients actuels. Le résultat contient juste un dossier client,
  celui précédemment créé.

```json
curl --location --request GET 'http://localhost:8080/api/dossier' \
--data-raw ''
```

