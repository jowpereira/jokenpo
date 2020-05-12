# jokenpo

Para iniciar é necessário fazer login

post

/login

body:

{
	"email":"user@gmail.com",
	"senha":"abc123"
}


lista todos os jogadors

get

/players

recuperar um jogador por id

get

/player/{id}

inserir novo jogador

post

/newPlayer

body:

{
    "nome": "player 2",
    "jogada": "spock"
}

remover um usuario pelo id

delete

/player/{id}

alterar um usuario por id

/player/{id}

Obs: aceita alteração no usuario ou jogada

ganhador

get

/winner
