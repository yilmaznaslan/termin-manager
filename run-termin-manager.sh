docker run \
  --name termin-manager \
  --net termin \
  -p 8080:8080 \
  -e SELENIUM_GRID_HOST='selenium' \
  -e ELASTICSEARCH_HOST='elasticsearch' \
  -e AWS_ACCESS_KEY_ID='AKIATUWIY5SLRR2ZPQHN' \
  -e AWS_SECRET_ACCESS_KEY='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' \
  -d \
  -t yilmaznaslan/termin-manager:master
