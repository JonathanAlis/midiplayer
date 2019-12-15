//package teste;


public class lista
{


	//1. variaveis de instancia:

	    private Nodo cabeca;
	    private int  tamanho;

	//2. metodo construtor 

	    public lista()
	    { this.cabeca  = null;
	      this.tamanho = 0;
	    }

	//3. verifica se a lista esta vazia

	    public boolean estaVazia()
	    { return(cabeca == null);
	    }

//	4. retorna o tamanho

	    public int tamanho()
	    { return tamanho;
	    }

//	5. insere um objeto na cabeca da lista

	    public void acrescentaItem(Object item)
	    { cabeca = new Nodo(item, cabeca);
	      tamanho++;
	    }

//	6. remove o primeiro nodo da lista (a cabeca)

	    public void removeItem()
	    { if(cabeca != null)
	      { cabeca = cabeca.proximo;
	        tamanho--;
	      }
	    }

//	7. retorna o primeiro nodo

	    public Nodo primoNodo()
	    { if(cabeca != null)
	      { return cabeca;
	      }
	      else return null;
	    }

//	8. retorna o objeto contido no primeiro nodo

	    public Object primoItem()
	    { if(cabeca != null)
	      { return cabeca.info;
	      }
	      else return null;
	    }

//	9. retorna o n-esimo nodo

	    public Nodo enesimoNodo(int n)
	    {
	      Nodo cabecax = cabeca;
	      for(int i=0;i<n;i++)
	      {cabecax = cabecax.proximo;
	      }
	      if(cabecax != null)
	      { return cabecax;
	      }
	      else return null;
	    }

//	10. retorna o objeto contido no n-esimo nodo

	    public Object enesimoItem(int n)
	    {
	      Nodo cabecax = cabeca;
	      for(int i=0;i<n;i++)
	      {
	        cabecax = cabecax.proximo;
	      }
	      if(cabecax != null)
	      { return cabecax.info;
	      }
	      else return null;
	    }

   public Object ultimoItem()
	    { Nodo nododavez = cabeca;
	      while(nododavez != null)
	      { if(nododavez.proximo==null) return nododavez.info;
	        else nododavez = nododavez.proximo;
	      }
	      return null;
	    }


//	11. insere um nodo contendo um objeto a direita de um nodo de referencia

	    public void acrescentaItem(Nodo noref, Object item)
	    {
	      Nodo nododavez = cabeca;
	      while(nododavez != null)
	      { if(nododavez==noref)
	        { Nodo noaux = nododavez.proximo;
	          nododavez.proximo = new Nodo(item, noaux);
	          tamanho++;
	          return;
	        }
	        else nododavez = nododavez.proximo;
	      }
	    }


	//12. remove um nodo qualquer

	    public void deletaNodo(Nodo no)
	    {
	      int k=0;
	      Nodo nododavez = cabeca;
	      while(nododavez != null)
	      { if(nododavez==no)
	        { if(k==0) {removeItem(); return;}
	          else
	          { Nodo noanterior = enesimoNodo(k-1);
	            noanterior.proximo = nododavez.proximo;
	            tamanho--;
	            return;
	          }
	        }
	        else nododavez = nododavez.proximo;
	        k++;
	      }
	    }


//	13. retorna o ultimo nodo

	    public Nodo ultimoNodo()
	    { Nodo nododavez = cabeca;
	      while(nododavez != null)
	      { if(nododavez.proximo==null) return nododavez;
	        else nododavez = nododavez.proximo;
	      }
	      return null;
	    }


	//14. verifica se um determinado item pertence a lista

	    public boolean pertence(Object item)
	    { Nodo nododavez = cabeca;
	      while(nododavez != null)
	      { if(item.equals(nododavez.info)) return true;
	        else nododavez = nododavez.proximo;
	      }
	      return false;
	    }

//	15. reverte a lista (a ser estudada na aula 14)

	    public void reverte()
	    { Nodo nododavez = cabeca;
	      cabeca = null;
	      while(nododavez != null)
	      { Nodo noaux = nododavez;
	        nododavez = nododavez.proximo;
	        noaux.proximo = cabeca;
	        cabeca = noaux;
	      }
	    }

//	16. verifica a igualdade entre esta (this) lista e uma outra

	    public boolean equals(Object objeto)
	    {
	      if (objeto == null || !(objeto instanceof lista)           ||
	          this.tamanho != ((lista) objeto).tamanho)
	      { return false;
	      }
	      Nodo p = this.cabeca;
	      Nodo q = ((lista)objeto).cabeca;
	      while(p != null)
	      { if (!p.info.equals(q.info))
	        { return false;
	        }
	        p = p.proximo;
	        q = q.proximo;
	      }
	      return true;
	    }

//	17. conversao de lista para cadeia

	    public String toString()
	    { String cadeia = "";
	      cadeia += "[";
	      if (cabeca != null)
	      { cadeia += cabeca.info;
	        Nodo nododavez = cabeca.proximo;
	        while (nododavez != null)
	        {
	          cadeia += ", " + nododavez.info;
	          nododavez = nododavez.proximo;
	        }
	      }
	      cadeia += "]";
	      return cadeia;
	    }
	    // 18. substotui enesimo item
	    
	    public void substituiItem(int n, Object item)
	    { this.enesimoNodo(n).info=item;
	    }
	    // 19. sublista. Retorna a sublista compreendida entre as posicoes i e j  

	    public lista sublista(int j, int k)
	    { lista b = new lista();
	      for(int i=k-1; i>=j; i--)
	      { b.acrescentaItem(this.enesimoItem(i));
	      }
	      return b;
	    }
	  //  troca. Troca as posicoes dos itens j-esimo e k-esimo (uma pela outra)
	    public void troca(int j, int k)
	    { Object infox = this.enesimoItem(j);
	      Object infoy = this.enesimoItem(j+1);
	      this.enesimoNodo(j).info=infoy;
	      this.enesimoNodo(j+1).info=infox;
	    }
	}
