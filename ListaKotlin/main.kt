/*
45. Leia a nota de 5 alunos. Para cada aluno, leia 4 notas, sendo que a primeira tem peso 3, a segunda peso 2 e a terceira e quarta peso 1. Calcule e apresente a média de cada aluno, dizendo se ele passou, não passou ou vai para a recuperação (e quantos pontos precisa para ser aprovado). Além disso, tire a média da turma.
*/

fun mediaTurma() {

  //ENTRADA
  print("Digite o número de alunos que deseja inserir notas: ")
  val numAlunos = readLine()!!.toInt()

  var notasAlunos = arrayOfNulls<Array<Double?>>(numAlunos)
  var mediaAlunos = arrayOfNulls<Double>(numAlunos)
  var situacaoAlunos = arrayOfNulls<String>(numAlunos)
  var somaMedias: Double = 0.0
    
  for (i in 0..(numAlunos-1)){
    
    var notasAluno = arrayOfNulls<Double>(4)
    var somaNotas: Double = 0.0

    for (j in 0..3){
      print("Digite a ${j+1}a nota do ${i+1}o aluno: ")
      var nota = readLine()!!.toDouble()
      //PROCESSAMENTO
      nota = when(j){
        0 -> nota * 3
        1 -> nota * 2
        else -> nota * 1
      }
      notasAluno[j] = nota
      somaNotas += nota
    }
    notasAlunos[i] = notasAluno
    var mediaAluno = somaNotas / 7
    mediaAlunos[i] = mediaAluno
    situacaoAlunos[i] = if(mediaAluno < 3){
                          "Reprovado."
                        }else if(mediaAluno < 7){
                          "Recuperação. Faltam ${7-mediaAluno} pontos para ser aprovado."
                        }else{
                          "Aprovado."
                        }
    somaMedias += mediaAluno
  }
  var mediaTurma = somaMedias / numAlunos

  //SAIDA
  for (i in 0..(numAlunos-1)){
    println("O ${i+1}o aluno teve média ${"%.2f".format(mediaAlunos[i])}. Situação: ${situacaoAlunos[i]}")
  }
  println("A média da turma foi ${"%.2f".format(mediaTurma)}.")
  
  /*notasAlunos.forEach{
    //it é igual ao array de notas de um aluno especifico
    it!!.forEach{
      //it é igual a uma nota de um aluno especifico
      println(it!!)
    }
  }*/
  
    
}

fun main(){
  var opc = -1

  while(opc != 0){
    println("\nEscolha a opção: ")
    println("1 - Média da turma ")
    println("0 - Sair ")  
    print(">>> ")
    opc = readLine()!!.toInt()
  
    when(opc){
      1 -> mediaTurma()   
    }
  }
  println("\nFIM DO PROGRAMA")
    
}