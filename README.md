# ufrgs-sdk-java
This SDK provides a simple way to communicate with the UFRGS API and its various endpoints.

Below a list of all available scopes:

### SCOPES
- **Meus Dados** this scope provides information about the user as well as his / her photo.
- **Biblioteca** this scope provides information related to loans made at the UFRGS library as well as enpoints necessary for their renewal.
- **Caronas** this scope provides all the endpoints needed for the Ufrgs Carona app [still in development]

### SDK ORGANIZATION
SDK provides a manager for each of the scopes plus an additional manager for token management.

- **UfrgsTokenManager**
- **UfrgsUserDataManager**
- **UfrgsLibraryManager**
- **UfrgsCaronasManager**

# Setup

## 1. Provide the gradle dependency

```gradle
Not yet available
```

## 2. Initialize the SDK
Be sure to initialize your SDK before making any calls.

```java
UfrgsAPI.initialize(false *isProduction*, *YOUT CLIENT ID*, *YOUR CLIENT SECRET*, *SCOPE REQUESTED*, *GRANT TYPE*);
```


This information is currently restricted to UFRGS's CPD.

## 3. Login/Request token

```java
ufrgsTokenManager.requestNewToken(context, username, password, new UfrgsTokenManager.OnTokenListener() {
            @Override
            public void onTokenReady(UfrgsToken token) {
                
            }

            @Override
            public void onError(String error) {

            }
        });
´´´

After getting the token from the user you can already initiate calls to the requested scopes.

