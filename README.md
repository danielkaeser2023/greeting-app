# greeting-app

## Entwicklerarbeitsplatz  

```bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=greeting-service
 ```

Beispielhaft für minikube und Rancher Desktop müssen die Images hineinkopiert werden

minikube
```bash
minikube image load greeting-service
 ```
Rancher Desktop
```bash
# see https://docs.rancherdesktop.io/how-to-guides/transfer-container-images
docker save -o /tmp/vaultdemo-image.tar vaultdemo:latest
nerdctl -n k8s.io load < /tmp/vaultdemo-image.tar
```

Danach kann mit Kustomize die App deployed werden
```bash
kubectl apply -k k8s
```

Wenn man jetzt ein Port Forwarding zwischen Kubernetes und Entwicklerarbeitsplatz macht, kann man den Service Endpunkt abfragen.
Das Ergebnis sollte aus der `k8s/application.yml` stammen.

```bash
kubectl port-forward service/greeting-service 8080:80
curl localhost:8080/greeting
```

