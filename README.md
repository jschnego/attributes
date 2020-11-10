Experiment zu Spracheinstellungen
---

Dieses Repository beinhaltet den Code sowie die Rohdaten und Auswertungen zu einem Experiment, welches im Zuge eines Seminars zum Thema "Spracheinstellungen" durchgeführt wurde.
Thema ist die Wahrnehmung mit deutschem Akzent artikulierter englischsprachiger Äußerungen.
Das Experiment wurde als Webapplikation aufgesetzt, eine Woche lang zum Sammeln von Daten zur Verfügung gestellt und ist nach wie vor online zu erreichen:

[Zum Experiment](http://138.197.183.98:8080/)

Insgesamt haben 13 Personen am Experiment teilgenommen.
Die Rohdaten der gemachten Angaben sind im JSON-Format unter `results/formatted/all_results.json` aggregiert zu finden, die Angaben einzelner Personen liegen unter einem einem Zeitstempel entsprechenden Namen im selben Ordner.

`ev.py` enthält einige Funktionen, welche zur Auswertung der Daten genutzt wurden.
Die Audiodateien können im .mp3-Format unter `src/main/resources/static/audio` eingesehen werden.

