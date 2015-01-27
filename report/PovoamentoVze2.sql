-- 1º etapa

INSERT INTO Funcionario (idFunc,tipoFunc,nome,nif,morada,localidade,telefone,telemovel,codigoPostal,dataNascimento,username,password) 
VALUES (1,"ADMIN", "Rui Oliveira", 1234123, "R. 5 de Outubro","Oliveira Santa Maria", "+351971234234", "+351234432765", "5434-343","1994-11-10", "User", "password"),
	(2,"FAM", "Rufino Felipe", 983423423, "R. André Cunha","Valadares", "+351973234754", "+351234834835", "4762-012","1991-02-23", "Rufinho", "indecifravel"),
    (3,"Fundos", "Teresa Frederica", 965475632, "R. da Minha","Vilar do Paraiso", "+351976524985", "+351234785412", "4712-012","1993-02-02", "Teresa", "teresa"),
    (4,"Obras", "Antonio Mafalda", 652365789, "R. Casais", "Gulpilhares", "+351976589210", "+351234985478", "4564-312","1993-09-15", "Antonio", "tone");


INSERT INTO Tarefa (idTar, designacao) VALUES
(1, "Colar Papel Interior"),
(2, "Pintar exterior"),
(3, "Colocar soalho"),
(4, "Instalação de tubagens"),
(5, "Limpar exterior"),
(6, "Instalação de pavimentos"),
(7, "Instalar quadro eletrico");

INSERT INTO Actividade (idAtividade, designacao) VALUES
(1, "Contrução civil"),
(2, "Pintura"),
(3, "Eletrotécnica"),
(4, "Carpintaria"),
(5, "Serviços");

INSERT INTO Questao (idQuestao, descricao, ativa) VALUES
(1, "Esta disposto a trabalhar conosco?",true),
(2, "Quais os problemas da casa atual?",true),
(3, "Tem terreno?",true),
(4, "Durante a obra, terá onde ficar?",true),
(5, "Em que dias estaria disponivel para trabalhar na obra?",true);

INSERT INTO TipoDonativo (idTipoDon, designacao, unidade) VALUES
(1, "Modetario", "€"),
(2, "Cimento", "sacos"),
(3, "Tijolo", "Kg"),
(4, "Areia", "Kg"),
(5, "Telha", "m2");

-- 2º etapa
INSERT INTO `Individuo` (`idIndiv`,`idFunc`,`nome`,`dataNascimento`,`profissao`,`codigoPostal`,`localidade`,`telefone`,`email`,`nif`, `isDoador`, `isVoluntario`) VALUES 
 (1,"3","Suki Swanson","1977-10-16","Pintor","4234-012","Murcia","0279487496","dis@pedeultrices.ca","952432066", true, false)
,(2,"3","Germane Gilbert","1969-10-09","Eletricista","4985-065","Ronciglione","0548532565","orci.Phasellus@tellus.edu","019358906", false, true)
,(3,"3","Basil P. Barry","1963-10-27","Contrutor civil","4874-065","Tramutola","0198111084","ullamcorper.viverra@et.ca","861537775", true, true)
,(4,"3","Heather Pierce","1968-10-16","Contrutor civil","4210-125","Piana degli Albanesi","0727621183","ipsum.dolor.sit@magna.org","195608919", false, true),
(5,"3","Edu Severina","1988-04-20","Pintor","4652-125","Penacova","9865214578","email@gmail.pt","857524541", false, true);

INSERT INTO `Familia` (`idFam`,`nome`,`morada`,`telefone`,`nif`,`dataNascimento`,`apelido`,`dataCriaFam`,`idFunc`) VALUES 
(1,"Tamara Brenna","927-7843 Rutrum Road","08690220","9267378","1976-09-18","Brenna","2009-06-06",2)
,(2,"Gregory Karen","Ap #767-1046 A, St.","03263331","03057537","1980-09-01","Karen","2008-10-05",2)
,(3,"Nichole Roanna","Ap #675-8686 Nunc Ave","06494977","359833","1977-01-13","Roanna","2007-12-11",2)
,(4,"Yeo Sigourney","838-8439 Nunc Rd.","09179132","9430232","1975-05-19","Sigourney","2007-03-17",2)
,(5,"Adelaide Francisco","Ap #945-2966 Porttitor Avenue","06562033","2673","1980-09-29","Francisco","2011-08-05",2)
,(6,"Jônatas Tristão","Ap #698-6871 Non, St.","04067542","41511670","1990-10-07","Tristão","2011-07-30",2);


INSERT INTO `ElementoFamilia` (`idElemento`,`idFam`,`nome`,`parentesco`,`dataNascimento`,`estadoCivil`,`ocupacao`,`escolaridade`) 
VALUES (1,1,"Lana Crosby","subrinho","1987-04-02","solteiro","Informatica","2ciclo"),
(2,1,"Quincy Cannon","pai","1993-11-04","casado","Motorista","3ciclo"),
(3,2,"Josephine Estrada","pai","1977-04-25","casado","Construtor Civil","ens. Superiror"),
(4,2,"Sybill Velazquez","primo","1981-09-23","solteiro","Agricultor","ens. Superiror"),
(5,3,"Patience Moody","primo","1981-12-01","solteiro","desempregado","2ciclo"),
(6,4,"Amaya Potter","filho","1982-07-10","solteiro","desempregado","ens. Superiror"),
(7,4,"Hyacinth Holden","mae","1976-02-28","solteiro","desempregado","ens. Superiror"),
(8,4,"Mia Sloan","primo","1990-09-27","solteiro","Agricultor","ens. Superiror"),
(9,5,"Ainsley Yang","filho","1989-01-12","casado","desempregado","2ciclo"),
(10,5,"Wendy Fleming","sobrinho","1982-01-28","solteiro","Sapateiro","ens. Superiror"),
(11,5,"Anjolie Martin","sobrinho","1980-02-06","solteiro","Empregado Textil","ens. Superiror"),
(12,6,"Carolyn Chase","pai","1964-09-06","casado","desempregado","ens. Superiror"),
(13,6,"Katelyn Blankenship","irmao","1955-08-04","casado","Eletricista","3ciclo"),
(14,6,"Indira Savage","irmao","1955-12-30","casado","Empregado Mesa","2ciclo"),
(15,6,"Brynn Pearson","mae","1961-02-09","casado","desempregado","2ciclo");

-- update ElementoFamilia e  set numElemento = (select max(numElemento) + 1 from ElementoFamilia ef where ef.idnumElementoFamilia = e.idFamilia);

INSERT INTO `Candidatura` (`idCand`,`idFam`,`dataCand`,`rendimento`, `estado`) 
VALUES (1,"1","2014-05-11",2000, 'Aprovado'),
(2,"1","2012-08-10",720, 'NAOAPROVADO'),
(3,"2","2013-12-24",1200, 'Aprovado'),
(4,"3","2013-12-28",776, 'Aprovado'),
(5,"4","2014-09-28",744, 'Aprovado'),
(6,"5","2015-11-19",888, 'Pendente'),
(7,"6","2014-12-29",422, 'Pendente');


INSERT INTO `CandidaturaQuestao` (idCand,idQuestao, resposta) 
VALUES (1 ,1,"Nao"),
(1 ,2,"Telhado destruido"),
(1 ,3,"Sim"),
(1 ,4,"Sim"),
(1 ,5,"Nunca"),
(2 ,1,"Sim"),
(2 ,2,"Idade avançada"),
(2 ,3,"Nao"),
(2 ,4,"Sim"),
(2 ,5,"Segundas e Terças"),
(3 ,1,"Nao"),
(3 ,2,"Sem eletricidade"),
(3 ,3,"Sim"),
(3 ,4,"Sim"),
(3 ,5,"Nunca"),
(4 ,1,"Sim"),
(4 ,2,"Canalização destruida");

-- select c.idCand + 41, c.rendimento * 1000, c.dataCand + INTERVAL 350 DAY as final, c.dataCand, c.dataCand + INTERVAL 350 DAY as final, 1, c.idCand, f.nome, "muito trabalho que falta, esta tudo por fazer", date(now())  from Candidatura c inner join Familia f on c.idfam = f.idFam  order by c.rendimento limit 30;

INSERT INTO `Projeto` (idProj, orcamento, prazo, dataInicio, dataFim, idFunc, idCand, designacao, descricao, dataCriaProj) VALUES
(1, 123000.00, "2016-06-29", "2015-07-15", "2016-06-29", 4,1, "Reparação do telhado", "Reparar o telhado para evitar a chuva","2014-12-21"),
(2, 136000.00, "2015-01-30", "2014-02-14", "2015-01-30", 4,3, "Reparações eletricas", "Reconstruir a instalação eletrica","2014-12-21"),
(3, 145000.00, "2016-01-05", "2015-01-20", "2016-01-05", 4,4, "Reparações da canalização", "Reconstruir a canalização","2014-12-21"),
(4, 154000.00, "2016-03-26", "2015-04-11", "2016-03-26", 4,5, "Contrução de casa nova", "Contruir casa de raiz para familia desalojada","2014-12-21");

-- select idProj,IdTar, date(p.dataInicio + INTERVAL TRUNCATE(RAND()*50,0) DAY) From Projeto p, Tarefa t;

INSERT INTO TarefaProjeto (idProj, IdTar, dataPlInicio, DataPlFim) 
VALUES(1, 1 ,"2014-10-23","2014-10-15"),
(1, 2 ,"2014-10-12","2014-10-15"),
(2, 3 ,"2014-11-10","2014-10-15"),
(2, 4 ,"2014-10-19","2014-10-15"),
(2, 5 ,"2014-10-20","2014-10-15"),
(3, 1 ,"2014-03-09","2014-02-11"),
(3, 2 ,"2014-03-15","2014-02-11"),
(4, 3 ,"2014-02-07","2014-02-11"),
(4, 4 ,"2014-02-09","2014-02-11"),
(4, 5 ,"2014-03-01","2014-02-11");

INSERT INTO Evento(idEv, designacao, data, idFunc, descricao) VALUES
(1, "Evento espontâneo", DATE(NOW()), 1, "Evento usado para donativos gerais"),
(2, "Angariação de fundos do sr. Luis", "2014-02-23", 1, "Evento usado para donativos de materiais"),
(3, "Dia de Natal", "2013-12-20", 1, "Evento usado para donativos monetarios");

-- select idIndiv,date(dataPlInicio + INTERVAL TRUNCATE(RAND()*10,0) DAY) as data1, TRUNCATE(RAND()*60, 0) as time ,idProj,idTar from Individuo,TarefaProjeto where idProj = 54  order by dataNascimento limit 50;

INSERT INTO IndividuoTarefaProjeto (idIndiv, dataTrabalho, duracao, idProj, idTar) 
VALUES(2, "2014-03-12", 12, 1, 1),
(2, "2014-03-23", 24, 3, 2),
(3, "2014-02-10", 43, 2, 3),
(5, "2014-02-13", 55, 2, 4),
(5, "2014-03-04", 4, 2, 5),
(3, "2014-03-18", 46, 3, 1),
(5, "2014-03-15", 45, 1, 2),
(2, "2014-02-14", 15, 4, 3),
(2, "2014-02-11", 14, 4, 4),
(3, "2014-03-06", 7, 4, 5);

-- select i.idIndiv as idIn,TRUNCATE(RAND()*5,0) from Individuo i union all select i.idIndiv as idIn,TRUNCATE(RAND()*5,0) from Individuo i;

INSERT INTO IndividuoActividade(idIndiv, idAtividade) 
VALUES(1, 4),
(2, 1),
(3, 2),
(4, 2),
(5, 4),
(1, 2),
(5, 2);

INSERT INTO Equipa(idEq, nacionalidadeEq, designacao, dataCriaEq, idFunc) VALUES
(1, "Portuguesa", "Empresa UnknownX", NOW(), 3),
(2, "Italiana", "Ferias de voluntariado", NOW(), 3),
(3, "Inglesa", "Associação Vicamonesis", NOW(), 3);

INSERT INTO EquipaIndividuo(idIndiv, idEq) 
VALUES(2,1),
(4,1),
(3,2),
(5,3);

-- select 115,date(dataPlInicio + INTERVAL TRUNCATE(RAND()*10,0) DAY) as data1, TRUNCATE(RAND()*60, 0) as time ,idProj,idTar from TarefaProjeto where idProj = 115;

INSERT INTO EquipaTarefaProjeto(idEq, dataTrabalho, duracao, idProj, idTar) VALUES
(1 ,"2014-03-15", 5 , 1, 2),
(2 ,"2014-03-02", 2 , 2, 4),
(3 ,"2014-03-22", 12 , 2, 5);

-- falta donativo donativoProjeto
-- set @a=0;select  concat("(",@a:=@a+1,",'na',10,10,1,'",date(NOW() - INTERVAL TRUNCATE(RAND()*100,0) DAY),"',1,1,",idIndiv ,")") from Individuo order by dataNascimento desc limit 40,80;
-- monetarios ocasionais

INSERT INTO Donativo(idDon, descricao, quantInicial, quantAtual, idTipoDon, dataDon, idFunc, idEv, idIndiv)
VALUES(1,'Doação regular',10,10,1,'2014-09-23',3,1,1),
(2,'Doação regular',10,10,1,'2014-10-24',3,1,1),
(3,'Doação de material em excesso',10,10,3,'2014-11-26',3,1,3),
(5,'Doação Monetaria',10,10,1,'2014-09-23',3,1,1);



INSERT INTO DonativoProjeto(idDon, idProj, dataDonProj, quantDonProj, idFunc)
VALUES
(1,1,'2014-10-29',4,3),
(3,2,'2014-11-12',1,3),
(5,2,'2014-10-29',4,3);

INSERT INTO Relatorio(obsRel, dataRel, idFam, idFunc)
VALUES
("Familia a habituar-se normalmente", "2014-12-21",1,1),
("Falta de limpeza externa da casa", "2014-12-21",2,1);

INSERT INTO Prestacao(idFunc, valor, data, idFam)
VALUES
(2,100,"2012-10-21",1),
(2,120,"2014-12-21",1),
(2,130,"2014-12-21",2),
(2,120,"2014-12-21",3),
(2,100,"2014-12-21",4);

