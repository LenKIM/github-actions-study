v=$(git rev-parse --short HEAD)
tag=$CI_PLAT.$v

echo tag

#docker run --rm --name local-postgre -d \
#       -p 5430:5432 -v "${PWD}"/schema:/docker-entrypoint-initdb.d \
#       joenggyu0/postgre:0.0.1
