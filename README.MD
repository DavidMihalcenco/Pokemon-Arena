PROIECT POO 2022
    
    1.Clase folosite in proiect :
        CreateItems
        Items
        Ability
        Arena
        Battle
        Logger
        Main
        Pokemon
        PokemonBuff
        PokemonFactory
        ReadFromFile
        Trainer
        
            In Clasa Create Items:
                Metoda Create Items :
                    Aceasta metoda primeste ca parametru un String cu un item care in metoda este creat 
                    cu ajutorul design Patternului Builder.
            
            In Clasa Items :
                Am Builder-ul pentru un item, toate atributele obiectului item.
            
            In Clasa Ability : 
                Aici se afla toate atributele unei abilitati.
            
            In Clasa Arena :
                Aici folosesc singleton pentru a crea doar o instanta de Arena, adica nu o sa am mai multe 
                arene pe care se bat pokemonii v-a fi doar una.
                
                Metoda randomOpponent :
                    Primeste ca parametru path-ul de unde trebuie sa citesc informatia despre treneri.
                    Aici creez pokemonii neutrel1 si neurel2, si extrag toti pokemonii fiecarui trener.
                    II echipez cu itemele date in fisier, si in dependenta de un numar care se v-a alege
                    random am 3 cazuri, cazul 1 cand un pokemon al fiecarui antrenor se bat cu neutrel 1
                    cazul 2 cand un pokemon al antrenorilor se bat cu neutrel2, si cazul 3 cand pokemonii 
                    trenerilor se bat intre ei, adica 1 cu 1 , al 2 cu al 2 etc. Si am o batalie finala unde
                    calculez suma atributelor fiecarui pokemon al trenerilor si aleg cel mai bun de la fiecare 
                    trener . Dupa ei se bat , castigatorul castiga si aventura. Toate aceste batalii sunt 
                    implementate prin threduri.
            
            In Clasa Battle :
                    Aici clonez pokemonii care ii primesc pentru batalie, pentru a putea dupa batalie sa ii 
                    aduc la starea initiala. Dupa fiecare batalie setez cd-ul abilitatilor la 0,pentru a nu
                    incepe urmatoare batalie cu cd pe abilitate. Si cel care a castigat primeste +1 la toate
                    atributele sale.
            
            In Clasa Logger : 
                    Raspunde de afisarea unei batalii. Primesc ca paramentru doua inturi care reprezinta
                    attack-ul fiecarui pokemon. Aflu care sunt aceste attak-uri. Daca hp-ul unuia din pokemoni
                    este 0 controlez care si in dependenta de pokemon afisez castigatorul.
            
            In Clasa Pokemon : 
                    Am toate atributele unui pokemon. 
                    
                    Metoda sumOfAll:
                        Sumez toate atributele pokemonului.

                    Metoda addStats1:
                        Adaug la toate atributele 1;
                    
                    Metoda attackTrue:
                        Imi intoarce cu ce attack sau abilitate pot sa attack. Daca s-a ales random de 
                        exemplu abilitate 1 dar ea are cd , atunci se v-a alege abilitate 2, dar daca are si
                        ea cd atunci dau cu attack simplu sau special.
                    
                    Metoda decreaseHP: 
                        Aici e toata logica scaderii Hp-ului unui pokemon.
                        Am doua if-uri care controleza daca pot folosi abilitatea, daca nu scad cu 0 cd-ul 
                        ramas.
                        Dupa am doua if-uri care in caz de am folosit abilitatea, pun cd pe ea.
                        M-am gandit sa fac doua cazuri aparte pentru neutrei pentru-ca ei dau doar cu attack.
                        Ma uit daca pokemon care ma ataca este in stun, daca da nu face nimic.
                        Si mai jos in dependenta de ce attack am sau abilitate fac totul dupa conditie.
                    
            Clasa PokemonBuff: 
                Aici primesc pokemonul si itemele lui, le creez si le atribui pokemonului.
                    
            Clasa PokemonFactory:
                Aici creez fiecare pokemon.

            ReadFromFile:
                Primesc un fisier si creez doi treneri cu atributele sale.

            Trainer:
                Aici am o clasa care raspunde de traineri, am 3 pokemon si 3 iteme dupa conditia
                proiectului.

                    
            
                    