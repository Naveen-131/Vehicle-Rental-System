
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { NavLink } from "react-router-dom";



const useStyles = makeStyles({
 /* root: {
    maxWidth: 345,
  },*/
  
  media: {
    height: 200,
  },
 
});

export default function MediaCard() {
  const classes = useStyles();

  return (
    <div className="container-fluid mt-3 mb-3 " >
    
    
<div className="row" >
<div className="col-sm-12 col-md-6 col-lg-4 col-xl-3 " >
    <Card style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
      <CardActionArea>
        <CardMedia
          className={classes.media}
          image="/pending.jpg" />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Pending List
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
          This card contains Pending list
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button className="rounded button" component={NavLink} to="/pending">
          View List
        </Button>
       
      </CardActions>
    </Card>
    </div>
    

    
    <div className="col-sm-12 col-md-6 col-lg-4 col-xl-3 " >
    <Card style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}} >
    <CardActionArea>
      <CardMedia
        className={classes.media}
        image="/inprogress.jpg"
        
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="h2">
          Inprogress List
        </Typography>
        <Typography variant="body2" color="textSecondary" component="p">
        This card contains Inprogress list
        </Typography>
      </CardContent>
    </CardActionArea>
    <CardActions>
      <Button className="rounded button" component={NavLink} to="/inprogress">
        View List
      </Button>
      
    </CardActions>
  </Card>
  </div>
  

  
  <div className="col-sm-12 col-md-6 col-lg-4 col-xl-3 " >
    <Card style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
    <CardActionArea>
      <CardMedia
        className={classes.media}
        image="/cancelled.png"
        
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="h2">
          Cancelled List
        </Typography>
        <Typography variant="body2" color="textSecondary" component="p">
        This card contains Cancelled list
        </Typography>
      </CardContent>
    </CardActionArea>
    <CardActions>
      <Button className="rounded button" component={NavLink} to="/cancelled">
        View List
      </Button>
     
    </CardActions>
  </Card>
  </div>
  

  
  <div className="col-sm-12 col-md-6 col-lg-4 col-xl-3 " >
  <Card style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
  <CardActionArea>
    <CardMedia
      className={classes.media}
      image="/completed.jpg"
      
    />
    <CardContent>
      <Typography gutterBottom variant="h5" component="h2">
        Completed List
      </Typography>
      <Typography variant="body2" color="textSecondary" component="p">
        This card contains Completed list
      </Typography>
    </CardContent>
  </CardActionArea>
  <CardActions>
    <Button className="rounded button" component={NavLink} to="/completed" >
      View List
    </Button>
   
  </CardActions>
</Card>
</div>
</div>


</div>

  
  );
}

