v=$(git rev-parse --short HEAD)

echo "$CI_FLAG"

#docker run --rm --name local-postgre -d \
#       -p 5430:5432 -v "${PWD}"/schema:/docker-entrypoint-initdb.d \
#       joenggyu0/postgre:0.0.1
