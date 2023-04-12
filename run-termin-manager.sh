docker run \
  --name termin-manager \
  --net termin \
  -p 8080:8080 \
  -e SELENIUM_GRID_HOST='selenium' \
  -e ELASTICSEARCH_HOST='elasticsearch' \
  -e AWS_ACCESS_KEY_ID='<REPLACE>' \
  -e AWS_SECRET_ACCESS_KEY='<REPLACE>' \
  -d \
  -t yilmaznaslan/termin-manager:master
