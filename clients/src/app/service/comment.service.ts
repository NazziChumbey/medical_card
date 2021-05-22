import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Comment} from '../models/comment.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CommentService {

  constructor(private http: HttpClient) {
  }

  private commentUrl = 'http://localhost:8080/service-api/';

  public getComments() {
    return this.http.get<Comment[]>(this.commentUrl);
  }

  public deleteComment(comment) {
    return this.http.delete(this.commentUrl + '/' + comment.idComment);
  }

  public createComment(comment,idPatient) {
    return this.http.post<Comment>(this.commentUrl + 'patients/' + idPatient + "/comments/", comment);
  }
}
