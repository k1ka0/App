# language: pt

Funcionalidade: Posts testes
	Como um usuario comum
	Gostaria de ver os posts
	
Cenario: Consultar e validar post com sucesso
	Dado que acesso post
	Quando tem retorno 200
	Entao entao retorno é
	| title 	| "sunt aut facere repellat provident occaecati excepturi optio reprehenderit" 						|
	| body		| "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"	|	