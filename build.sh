## Get the branch name
branch=$(git branch --show-current)
echo "Branch name is $branch"

tagName=yilmaznaslan/termin-manager:$branch
echo "Build the image tag: $tagName"
docker build --tag $tagName --file Dockerfile .

echo "Pushing image to container registery"
docker push $tagName