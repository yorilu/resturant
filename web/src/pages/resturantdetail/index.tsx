import { View, Text } from '@tarojs/components'
import { useLoad } from '@tarojs/taro'
import { useState } from "react"
import axios from '@axios'
import './index.scss'
import {REQUEST_URL} from ENV;

export default function Index() {
  
  const [resturant, setResturant] = useState([]);


  useLoad(async () => {
    query(1);
  })

  function query(props){
    const {
      resturantId = ''
    } = props;

    const info = axios.post(REQUEST_URL, "getResturantDetail", {
      resturantId
    }) || null;

    if(info){
      setResturant(info);
    }
  }

  function Resturant(info){

    const {
      name = '',
      foodItems = '',
      address = ''
    } = info;

    return (
      <View className='resturant'>
        <View className='name'>{name}</View>
        <View className='food-items'>{foodItems.splig(":")}</View>
        <View className='address'>address</View>
      </View>
    )
  }

  return (
    <View className='index'>
      <View className="title">餐厅详情</View>
      <View className="resturant">
          <Resturant info = {info}></Resturant>
      </View>
    </View>
  )
}
