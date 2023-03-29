# Build the fatjar
echo "building the jar"
./gradlew build

## Get the branch name
branch=$(git describe --contains --all HEAD)
echo "Branch name is $branch"

tagName=yilmaznaslan/termin-manager:$branch
echo "Build the image tag: $tagName"
docker build --tag $tagName --file Dockerfile .

# Push the image to a docker registery `
echo "Pushing image to container registery"
docker push $tagName