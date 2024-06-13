####Aufgabe 2.4

Mit Threads implementieren

```pseudocode
Haupt-Thread{
	while(true){
  	N <- Liste
  	E <- Ext(N)
  	thread(t2,N,E)
	}
}
Diest-Thread{
	t2(N,E){
		IP <- E
		V <- IP
    Senden(N,V)
    close(V)
	}
}

```

Prozesse sind teuer für BS

Kommunikation zwischen Prozesse sind schwierig

#### Aufgabe 2.5

#####dl:

| 0    |      |
| ---- | ---- |
| 1    |      |
| 2    |      |
| 3    |      |
| 4    |      |
| 5    |      |
| 6    |      |
| 7    |      |
| 8    |      |
| 9    |      |
| 10   |      |

7->8 frei, 3 drucke



lies "frei" -> R

Schreibe "dl[R]"

"frei" = R+1 -> "frei"++

oben 3 Zeile von Befehle sind nicht "atomar"

|                       $T_1$                        |                       $T_2$                        |
| :------------------------------------------------: | :------------------------------------------------: |
| $lies \ "frei"\rightarrow R(6) WiderspruchZeichen$ |                                                    |
|                                                    | $Lies\ "frei"\rightarrow R(6)\ WiderspruchZeichen$ |
|      $Schreibe\ "dl[6]"\ WiderspruchZeichen$       |                                                    |
|                                                    |       $Schreibe "dl[6]"\ WiderspruchZeichen$       |
|           $"frei"=7\ WiderspruchZeichen$           |                                                    |
|                                                    |              $"frei"=7\rightarrow 8$               |

Mutual Exclusion = beidseitiges Ausschluss

Kritische Abschnitt darf gleichzeitig nur ein Thread zugreifen