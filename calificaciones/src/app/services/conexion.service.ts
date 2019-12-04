import { Injectable } from '@angular/core';
import { AngularFirestore, AngularFirestoreCollection, AngularFirestoreDocument } from '@angular/fire/firestore';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


export interface Item { nombre: string;
                        nota1: number;
                        nota2: number;
                        total: number;
                        }


@Injectable({
  providedIn: 'root'
})

export class ConexionService {
  
  private itemsCollection: AngularFirestoreCollection<Item>;
  estudiantes: Observable<Item[]>;

  private itemDoc: AngularFirestoreDocument<Item>;
  
  constructor(private afs: AngularFirestore) { 
    this.itemsCollection = afs.collection<Item>('estudiantes');
    this.estudiantes = this.itemsCollection.snapshotChanges().pipe(
      map(actions => actions.map(a => {
        const data = a.payload.doc.data() as Item;
        const id = a.payload.doc.id;
        return { id, ...data };
      }))
    );     
  }

  listaItem(){
    return this.estudiantes;
  }

  agregarItem(item: Item) {
    this.itemsCollection.add(item);
  }
}
