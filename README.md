# kaniko-demo

## Execute undernoted commands in sequence

```
minikube start
```

```
mkdir -p /tmp/git/
```

```
cd /tmp/git/
```

```
cd /tmp/git/
```

```
git clone git@github.com:sinhasonalkumar/kaniko-demo.git
```

```
cd kaniko-demo
```

```
mvn clean package
```

### in new tab
```
minikube mount /tmp/git/kaniko-demo:/tmp/sourceCode/kaniko-demo &
```

```
export REGISTRY_SERVER=https://index.docker.io/v1/

export REGISTRY_USER=[replace_with_your_dockerhub_username]

export REGISTRY_PASS=[replace_with_your_dockerhub_access_token]

export REGISTRY_EMAIL=[replace_with_your_email_id]
```

```
kubectl create secret \
    docker-registry docker-reg-secret \
    --docker-server=$REGISTRY_SERVER \
    --docker-username=$REGISTRY_USER \
    --docker-password=$REGISTRY_PASS \
    --docker-email=$REGISTRY_EMAIL
```

```
kubectl apply -f infra/kaniko-docker-build.yaml
```

```
kubectl exec -it kaniko -- sh
```

```
cd /sourceCode
```

```
/kaniko/executor --context `pwd` --dockerfile `pwd`/Dockerfile --destination sinhasonalkumar/demo-springboot-svc-kaniko:0.0.1
```

```
docker pull sinhasonalkumar/demo-springboot-svc-kaniko:0.0.1
```

```
kubectl create deployment kaniko-demo --image=sinhasonalkumar/demo-springboot-svc-kaniko:0.0.1
```

```
kubectl expose deployments kaniko-demo --type=ClusterIP --target-port=8080 --port=8080
```

```
kubectl port-forward svc/kaniko-demo 8080:8080
```

```
curl http://localhost:8080/ps/actuator/health | jq .
```

```
curl http://localhost:8080/ps/actuator/info | jq .
```
