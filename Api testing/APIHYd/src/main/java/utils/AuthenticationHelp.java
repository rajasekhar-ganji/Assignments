package utils;

interface AuthenticationHelp {
	void NoAuthentication();
	void AkamaiEdgeGridAuthentication();
	void ApiKeyAuthentication();
	void BearerTokenAuthentication();
	void HawkAuthentication();
	void JWTBearerAuthentication();
	void OAuth1();
	void OAuth2();
	void NTLMAuthentication();
	void BasicAuth();
	 void DigestAuth();
	 void AWSSignature();
}
