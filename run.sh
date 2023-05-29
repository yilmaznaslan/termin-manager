docker run \
  --name termin-manager \
  --net termin \
  -e SELENIUM_GRID_HOST='selenium' \
  -e ELASTICSEARCH_HOST='elasticsearch' \
  -p 8080:8080 \
  -d \
  -t yilmaznaslan/termin-manager:master
