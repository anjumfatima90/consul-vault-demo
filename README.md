# consul-vault-demo

## Consul
1. Start consul: `consul agent -node machine -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=<YOUR_IP_ADDRESS>`
2. Go to http: localhost:8500
3. Create the key/value for username: `config/consul-vault-demo/consul.username=consuluser`
4. Create the key/value for password: `config/consul-vault-demo/consul.password=consulpassword`

## Vault
1. Start the vault server: `vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"`
2. Provide authentication token: `export export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"`
3. Set vault end point: `export VAULT_ADDR="http://127.0.0.1:8200"`
4. Store a configuration key-value pairs inside Vault: `vault kv put secret/consul-vault-demo vault.username=vaultuser vault.password=vaultpassword`


### Package the application
1. mvn clean package


### Run the application in wlp
1. Create a server in wlp: Go to wlp and run `bin/server create`
2. Copy the application jar inside wlp/usr/servers/defaultServer/dropins/spring folder: `cp <path-to>/consul-vault-demo/target/consul-vault-demo-0.0.1-SNAPSHOT.jar <path-to>/wlp/usr/servers/defaultServer/dropins/spring/`
3. Add the following features in wlp/usr/servers/defaultServer/server.xml: `springBoot-2.0` and `servlet-4.0`
3. Run the server: Go to wlp and run `bin/server run`
