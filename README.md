```angular2html
docker run --rm --name local-actions-study -d \
-v ${PWD}/schema:/docker-entrypoint-initdb.d \
-p 5430:5432 \
-e POSTGRES_PASSWORD="study" \
-e POSTGRES_USER="study" \
-e POSTGRES_DB="actions-study"  \
postgres
```
