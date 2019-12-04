import { Component, OnInit } from '@angular/core';
//
import { AngularFirestore } from 'angularfire2/firestore';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  estudiantes: Observable<any[]>;
  constructor(db: AngularFirestore) { 
    this.estudiantes = db.collection('estudiantes').valueChanges();
  }

  ngOnInit() {
  }

}
