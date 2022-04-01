# PACMAN
TP6 : Pac-Man

## TODO
Méthode à implémenter :

Game :
- setPoints
- levelUp
- over
- start

Grid :
- init
- isAWall

Pacman :
- superpower
- spawn
- die
- hurt
- move
- nbFruitsEaten
- isOnGhost
- isOnFruit
- eatGhost
- eatFruit

Ghost :
- isEaten
- spawn
- getShape
- getBehaviour
- die
- move

### Règles pour les méthodes des interfaces :
- Utilisation de l'anglais pour le nom des fichiers, méthodes et attributs mais commentaires en français.
- On distingue les **Interfaces** par le **I** devant le nom.
- Pas besoin de **répeter** le nom de l'objet dans la méthode. *Exemple: pacman.movePacman() --> pacman.move()*.
- Préciser **la couche** pour chaque classe / interface en début de nom. *Exemple: PacmanInterface --> DataPacmanInterface*.
- Les méthodes et attributs concernant **plusieurs objets** à la fois et relatif au jeu sont à mettre dans la classe **Game** pour chaque couches. *Exemple: NbFruitsLeft() à mettre dans la classe Game et non dans la classe Fruit*.