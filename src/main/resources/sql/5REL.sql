--Relatório Educação e Mobilidade
SELECT ALU.NOME,
	ALU.DATANASCIMENTO,
	ALU.ID,
	ONI.LINHASONIBUS
FROM TB_ALUNO ALU
JOIN TB_BUSOLOGO ONI ON ALU.NOME LIKE ONI.NOME
WHERE ONI.LINHASONIBUS IS NOT NULL
GROUP BY ALU.NOME,
	ALU.DATANASCIMENTO,
	ALU.ID,
	ONI.LINHASONIBUS