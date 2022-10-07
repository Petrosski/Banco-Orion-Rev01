import java.util.Scanner;
public class principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Auxiliar aux = new Auxiliar();
		int op = 1, cont = 0, repeat = 0, numCasa, cep, id = 0;
		String cpf, profissao, user, nome, nomeRua, complemento, cidade, uf;
		double renda;
		boolean logado = false, busca = false;
		ContaCorrente[] cc = new ContaCorrente[30];
		
		while(repeat == 0) {
			do {
				aux.menuLogar();
				op = sc.nextInt();
				if(op == 1) {
					cc[cont] = new ContaCorrente();
					System.out.println("Bem vindo!!");
					System.out.println("Qual seu CPF: ");
					cpf = sc.next();
					System.out.println("Qual sua profissão: ");
					profissao = sc.next();
					System.out.println("Qual sua renda? ");
					renda = sc.nextDouble();
					System.out.println("Digite seu nome: ");
					nome = sc.next();
					System.out.println("Digite o nome da rua: ");
					nomeRua = sc.next();
					System.out.println("Digite o número da casa: ");
					numCasa = sc.nextInt();
					System.out.println("Digite o complemento: ");
					complemento = sc.next();
					System.out.println("Digite o CEP: ");
					cep = sc.nextInt();
					System.out.println("Digite a cidade: ");
					cidade = sc.next();
					System.out.println("Digite a UF: ");
					uf = sc.next();	
					Pessoa pessoa = new Pessoa(nome, nomeRua, numCasa, complemento, cep, cidade, uf, cpf, profissao, renda);
					
					cc[cont].setLimiteConta(renda*2);
					cc[cont].setPessoa(pessoa);
					cc[cont].setNumeroConta(cont+1);
					cc[cont].setAgencia("1010");
					cont += 1;
				} else if (op == 2) {
					System.out.println("Digite seu CPF: ");
					user = sc.next();
					if (cont == 0) {
						System.out.println("Usuário inválido !!");
						break;
					}
					for (int i = 0; i < cont; i++) {
						if (user.equals(cc[i].getPessoa().getCPF())) {
							logado = true;
							id = i;
							break;
						} else {
							System.out.println("Usuário inválido !!");
							logado = false;
						}
					}
				} else if (op == 0) {
					System.exit(0);
				}
				while(logado) {
					System.out.println("\n\n========= BEM VINDO " + cc[id].getPessoa().getNome() + " =========");
					aux.menuUser();
					op = sc.nextInt();
					switch (op) {
					case 0: {
						logado = false;
						break;
					}
					case 1: {
							System.out.println("Quantos valor você deseja depositar?");
							double valor = sc.nextDouble();
							cc[id].setSaldo(valor);
							System.out.printf("\nSaldo de %.2f efetuado com sucesso !", valor);
						break;
					}
					case 2: {
						System.out.println("Quantos valor você deseja sacar?");
						double valor = sc.nextDouble();
						if(cc[id].sacar(valor)) {
							System.out.printf("Saque de %.2f efetuado com sucesso !!", valor);
						} else {
							System.out.println("Saldo insuficiente !!");
						}
						break;
					}
					case 3: {
						System.out.println("Digite CPF de destinatário: ");
						user = sc.next();
						for (int i = 0; i < cont; i++) {
							if (user.equals(cc[i].getPessoa().getCPF())) {
								System.out.println("Digite valor da transferência: ");
								double valor = sc.nextDouble();
								if (cc[id].transferir(cc[i], valor)) {
									System.out.println("Transferência efetuada com sucesso !!");
									busca = true;
									break;
								}
							} else {
								busca = false;
							}
						}
						if(!busca) {
							System.out.println("Transferência negada !!");
						}
						break;
					}
					case 4: {
						System.out.println("Olá" + cc[id].getPessoa().getNome());
						System.out.printf("Seu saldo é %.2f", cc[id].getSaldo());
						break;
					}
					case 5: {
						System.out.println("Número da conta: "+ cc[id].getNumeroConta());
						System.out.println("Número da agência: "+ cc[id].getAgencia());
						do {
							aux.configuracao();
							op = sc.nextInt();
							
							switch(op) {
								case 1: {
									System.out.println("Digite seu novo nome:");
									nome = sc.next();
									cc[id].getPessoa().setNome(nome);
									break;
								}
								case 2: {
									System.out.println("Seu limite bancário é" + cc[id].getLimiteConta());
									break;
								}
								case 3: {
									System.out.println("Qual sua nova renda: ");
									renda = sc.nextDouble();
									cc[id].getPessoa().setRenda(renda);
									cc[id].setLimiteConta(renda*2);
									break;
								}
								default:{
									System.out.println("Valor Inválido !!");
								}
							}
						} while(op != 0);
						op = 1;
						break;
					}
					
					default:
						System.out.println("Valor inválido !!");
						break;
					}
				};
				
			} while(op != 0);
	
		}
		sc.close();
	}

}
