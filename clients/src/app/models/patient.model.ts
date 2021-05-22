import {Comment} from './comment.model';

export class Patient {

  id: number;
  firstName: string;
  lastName: string;
  dateOfBirth: Date;
  sex: string;
  country: string;
  state: string;
  address: string;
  comments: Comment;
}
